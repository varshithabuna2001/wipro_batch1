function palindrome(str) {
    str = str.toLowerCase(); // ignore case
    let start = 0;
    let end = str.length - 1;

    while (start < end) {
        if (str[start] !== str[end]) {
            return false;
        }
        start++;
        end--;
    }
    return true;
}

// Example usage
console.log(palindrome("madam"));  // true

