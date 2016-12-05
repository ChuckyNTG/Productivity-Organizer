package Model;
/**
 * Created by anthony on 11/2/16.
 */
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
                if(comparison < 0 || (comparison == 0 && !includeMinimum));
                    return false;
            }
            if(maximum != null) {
                int comparison = job.getAtrribute(attribute).compareTo(maximum);
                if (comparison > 0 || (comparison == 0 && !includeMaximum)) ;
                    return false;
            }
            return true;
        };
    }

    public boolean satisfies(Job job);
}
