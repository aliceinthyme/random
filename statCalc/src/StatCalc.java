public class StatCalc { //I honestly just wrote this on a whim since the author for a story I was reading was pretty transparent about their formula for stats etc.
    public static void main(String[] args) throws Exception {
        try {
            System.out.println(stats(Integer.parseInt(args[0])));
            System.out.println(credits(Integer.parseInt(args[0])));
        } catch (NumberFormatException e) {
            System.out.println("Invalid input, integers only.");
        } catch (OutOfRangeException e) {
            System.out.println("Credits not calculable for n < 2, stats not calculable for n < 1");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Please run again with valid argument!");
        }
    }
    private static int stats(int n) throws OutOfRangeException {
        if (n >= 1) {
            int result= 20;
            for(int i = 2; i <= n; i++) {
                result = result * (i+1)/(i-1);
            }
            return(result);
        } else {
            throw new OutOfRangeException();
        }
    }
    private static int credits(int n) throws OutOfRangeException {
        int result;
        if(n > 1) {
            double a = stats(n-1);
            double b = stats(n);
            double c = 25d/3d;
            double n1 = n+1;
            double n2 = n-1;
            assert n2 != 0; //division by 0
            double result_ = ((a+b)*(n1/n2)*c)/n;
            result = (int)result_;
            return(result);
        } else {
            throw new OutOfRangeException();
        }
    }   
}

