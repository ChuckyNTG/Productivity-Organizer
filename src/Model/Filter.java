package Model;

public interface Filter {
    public static class RangeFilter implements  Filter{
        String attribute;
        Comparable maximum;
        Comparable minimum;
        boolean includeMinimum;
        boolean includeMaximum;
        public RangeFilter(String attribute, Comparable minimum , Comparable maximum, boolean includeMinimum, boolean includeMaximum){
            this.attribute = attribute;
            this.maximum = maximum;
            this.minimum = minimum;
            this.includeMaximum = includeMaximum;
            this.includeMinimum = includeMinimum;
        }

        public RangeFilter(String attribute, Comparable minimum, Comparable maximum){
            this(attribute, minimum, maximum, true, true);
        }

        @Override
        public boolean satisfies(Job job){
            if(minimum != null){
                int comparison = job.getAtrribute(attribute).compareTo(minimum);
                System.out.println(job.getAtrribute(attribute) + " ~ " + minimum + " = " + comparison);
                if(comparison < 0 || (comparison == 0 && !includeMinimum)) {
                    System.out.println(comparison);
                    return false;
                }
            }
            if(maximum != null) {
                int comparison = job.getAtrribute(attribute).compareTo(maximum);
                System.out.println(job.getAtrribute(attribute) + " ~ " + maximum + " = " + comparison);
                if (comparison > 0 || (comparison == 0 && !includeMaximum)) {
                    System.out.println(comparison);
                    return false;
                }
            }
            return true;
        };
    }

    public static class AcceptingFilter implements Filter {
        @Override
        public boolean satisfies(Job job) {
            return true;
        }
    }

    public static class KeywordFilter implements Filter{
        String attribute;
        String keyword;

        public KeywordFilter(String attribute, String keyword){
            this.attribute = attribute;
            this.keyword = keyword;
        }

        @Override
        public boolean satisfies(Job job) {
            if(keyword == null || keyword.length() < 1)
                return true;
            if(attribute == null){
                for(Comparable c : job.allAtributes()){
                    if(c.toString().toUpperCase().contains(keyword.toUpperCase()))
                        return true;
                }
            }
            Comparable toCheck = job.getAtrribute(attribute);
            if(toCheck == null)
                return false;
            return toCheck.toString().toUpperCase().contains(keyword.toUpperCase());
        }
    }

    public boolean satisfies(Job job);
}
