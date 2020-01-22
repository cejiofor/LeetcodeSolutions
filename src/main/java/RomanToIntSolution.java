class RomanToIntSolution {
    public static int romanToInt(String s) {
        char current = ' ';
        char next = ' ';
        int sum = 0;
        int index = 0;
        while(index < s.length()){
            current = s.charAt(index);
            if (index<s.length()-1){
                next = s.charAt(index+1);
            }
            else{
                next = ' ';
            }
            
            switch(current){
                case 'M':
                    sum += 1000;
                    break;
                case 'D':
                    sum += 500;
                    break;
                case 'C':
                    if(next == 'M'){
                        sum += 900;
                        index++;
                    }
                    else if(next == 'D'){
                        sum += 400;
                        index++;
                    }
                    else{
                        sum += 100; 
                    }
                    break;
                case 'L':
                    sum += 50;
                    break;
                case 'X':
                    if(next == 'C'){
                        sum += 90;
                        index++;
                    }
                    else if(next == 'L'){
                        sum += 40;
                        index++;
                    }
                    else{
                        sum += 10; 
                    }
                    break; 
                case 'V':
                    sum += 5;
                    break;
                case 'I':
                    if(next == 'X'){
                        sum += 9;
                        index++;
                    }
                    else if(next == 'V'){
                        sum += 4;
                        index++;
                    }
                    else{
                        sum += 1; 
                    }
                    break;      
            }
            index++;
        }
        
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("MCMXCIV"));
        System.out.println(romanToInt("I"));
        System.out.println(romanToInt("MMMCMXCIX"));
    }
}