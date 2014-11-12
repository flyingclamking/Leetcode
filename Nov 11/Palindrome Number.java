public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        
        int length = 1;
        while (x / length >= 10) {
            length *= 10;
        }
        
        while (x != 0) {
            int first = x / length;
            int last = x % 10;
            if (first != last) {
                return false;
            }
            x = (x % length) / 10;
            length /= 100;
        }
        
        return true;
    }
}

//May Overflow when reverse an Integer
public class Solution {
    public boolean isPalindrome(int x) {
        
        if (x < 0) {
            return false;
        }
        
        int reverse = 0;
        int temp = x;
        while (x != 0) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        
        return reverse == temp;
    }
}

//Excellent recursive solution
//However without address manipulation in JAVA this can't be done
bool isPalindrome(int x, int &y) {
  if (x < 0) return false;
  if (x == 0) return true;
  if (isPalindrome(x/10, y) && (x%10 == y%10)) {
    y /= 10;
    return true;
  } else {
    return false;
  }
}
bool isPalindrome(int x) {
  return isPalindrome(x, x);
}
