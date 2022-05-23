public class Length {
    private final double value;
    private final Unit unit;

    public Length(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    /**
     * 想要用unit替换String
     * @return
     */
    public Length as(Unit targetUnit) {
        double value = newValueIn(targetUnit);
        return new Length(value, targetUnit);
    }

    private double newValueIn(Unit targetUnit) {
        if (this.unit == Unit.FOOT) {
            if (targetUnit == Unit.YARD) {
                return this.value /3;
            }
            if (targetUnit == Unit.INCH) {
                return this.value * 12;
            }
        }

        if (this.unit == Unit.YARD) {
            if (targetUnit == Unit.INCH) {
                return this.value * 36;
            }
            if (targetUnit == Unit.FOOT){
                return this.value *3;
            }
        }

        if (this.unit == Unit.INCH) {
            if (targetUnit == Unit.FOOT) {
                return this.value / 12;
            }
            if (targetUnit == Unit.YARD) {
                return this.value /36;
            }
        }
        return this.value;
    }

    public double getValue() {
        return value;
    }

    public Unit getUnit() {
        return unit;
    }
}
