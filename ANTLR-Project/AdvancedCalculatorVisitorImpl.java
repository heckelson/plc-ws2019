/**
 * @author heckelson
 * @id m-nr
 */

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class AdvancedCalculatorVisitorImpl extends AdvancedCalculatorBaseVisitor<BigDecimal> {
    private Map<String, BigDecimal> variables = new HashMap<>();

    @Override
    public BigDecimal visitNum(AdvancedCalculatorParser.NumContext ctx) {
        return new BigDecimal(ctx.NUMBER().getText());
    }

    @Override
    public BigDecimal visitParens(AdvancedCalculatorParser.ParensContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public BigDecimal visitMulDiv(AdvancedCalculatorParser.MulDivContext ctx) {
        final BigDecimal left = visit(ctx.expression(0));
        final BigDecimal right = visit(ctx.expression(1));
        if (ctx.op.getText().equals("*")) {
            return left.multiply(right).setScale(9);
        } else {
            return left.divide(right, 9, RoundingMode.HALF_UP);
        }
    }

    @Override
    public BigDecimal visitAddSub(AdvancedCalculatorParser.AddSubContext ctx) {
        final BigDecimal left = visit(ctx.expression(0));
        final BigDecimal right = visit(ctx.expression(1));
        if (ctx.op.getText().equals("+")) {
            return left.add(right).setScale(9);
        } else {
            return left.subtract(right).setScale(9);
        }
    }

    @Override
    public BigDecimal visitAssign(AdvancedCalculatorParser.AssignContext ctx) {
        String varname = ctx.getChild(0).getText();
        BigDecimal number = visit(ctx.getChild(2));

        variables.put(varname, number);

        return number.setScale(9);
    }

    @Override
    public BigDecimal visitVar(AdvancedCalculatorParser.VarContext ctx) {
        BigDecimal number = variables.getOrDefault(ctx.getChild(0).getText(), new BigDecimal(0));

        return number.setScale(9);
    }

    @Override
    public BigDecimal visitExpr(AdvancedCalculatorParser.ExprContext ctx) {
        return visit(ctx.expression());
    }

    // Extension: Modulo
    @Override
    public BigDecimal visitMod(AdvancedCalculatorParser.ModContext ctx) {
        int left = visit(ctx.expression(0)).intValueExact();
        int right = visit(ctx.expression(1)).intValueExact();

        return new BigDecimal(left % right);
    }

    // Extension: DEBUG
    @Override
    public BigDecimal visitDebug(AdvancedCalculatorParser.DebugContext ctx) {
        for(String key : variables.keySet()) {
            System.out.println(key + " = " + variables.get(key));
        }

        return new BigDecimal(0);
    }
}
