package Calculator;

 class Roman {
  static String[] romanNumerals = new String[]{"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
          "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
          "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
          "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
          "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
          "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
          "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

  //проверка на наличие в массиве числа с таким же индексом
   static boolean isRoman(String val){
   int i;
   for(i=0; i<romanNumerals.length; i++){
    if (val.equals(romanNumerals[i])){
     return  true;
    }
   }
   return  false;
  }

  static int convertToArabian(String roman){
   for (int i=0;i<romanNumerals.length;i++){
    if (roman.equals(romanNumerals[i])){
     return i;
     }
    }
   return -1; //если не нашли такое же арабское число
  }

  static String convertToRoman(int arabian) {
   final String s = romanNumerals[arabian];
   return s;
    }
  }
