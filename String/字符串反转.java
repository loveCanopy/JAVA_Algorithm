 
//用栈
 public static String reverse7(String s) {
  char[] str = s.toCharArray();
  Stack<Character> stack = new Stack<Character>();
  for (int i = 0; i < str.length; i++)
   stack.push(str[i]);
  
  String reversed = "";
  for (int i = 0; i < str.length; i++)
   reversed += stack.pop();
  
  return reversed;
 }


 //递归
 public static String reverse1(String s) {
  int length = s.length();
  if (length <= 1)
   return s;
  String left = s.substring(0, length / 2);
  String right = s.substring(length / 2, length);
  return reverse1(right) + reverse1(left);
 }


  public static String reverse3(String s) {
  char[] array = s.toCharArray();
  String reverse = "";
  for (int i = array.length - 1; i >= 0; i--)
   reverse += array[i];
  
  return reverse;
 }