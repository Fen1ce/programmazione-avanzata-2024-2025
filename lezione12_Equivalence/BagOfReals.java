public class BagOfReals {
    private double[] doubleArrayValues;

    //Costruttore
    public BagOfReals(double[] doubleArrayValues) {
        this.doubleArrayValues = doubleArrayValues;
    }
    //Pseudo-Costruttore
    public static BagOfReals createBag(String input) {
        String[] stringArrayValues = input.split(",");
        double[] doubleArrayValues = new double[stringArrayValues.length];
        for (int i = 0; i < stringArrayValues.length; i++) {
            doubleArrayValues[i] = Double.parseDouble(stringArrayValues[i].trim());
        }
        return new BagOfReals(doubleArrayValues);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        BagOfReals other = (BagOfReals) obj;
        if (this.doubleArrayValues.length != other.doubleArrayValues.length ) {
            return false;
        }
        boolean[] used = new boolean[other.doubleArrayValues.length];
        for (double doubleArrayValue : this.doubleArrayValues) { //utilizzo del for each
            boolean found = false;
            for (int j = 0; j < other.doubleArrayValues.length; j++) {
                if (!used[j] && doubleArrayValue == other.doubleArrayValues[j]) {
                    used[j] = true;
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        if  (doubleArrayValues.length == 0) {
            return "[]";
        } else  {
            String str = "[";
            for (int i = 0; i < (doubleArrayValues.length-1); i++) {
                str += doubleArrayValues[i] + ", ";
            }
            str += doubleArrayValues[doubleArrayValues.length-1] + "]";
            return str;
        }
    }
}