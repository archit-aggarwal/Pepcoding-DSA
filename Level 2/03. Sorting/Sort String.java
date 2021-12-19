        int[] lowerCase = new int[26];
        int[] upperCase = new int[26];
        int[] digits = new int[10];
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            if(ch >= 'a' && ch <= 'z'){
                lowerCase[ch - 'a']++;
            } else if(ch >= 'A' && ch <= 'Z'){
                upperCase[ch - 'A']++;
            } else {
                digits[ch - '0']++;
            }
        }
        
        
        StringBuilder sb = new StringBuilder("");
        for(int i=0; i<10; i++){
            char ch = (char)(i + '0');
            for(int j=0; j<digits[i]; j++){
                sb.append(ch);
            }
        }
        for(int i=0; i<26; i++){
            char ch = (char)(i + 'A');
            for(int j=0; j<upperCase[i]; j++){
                sb.append(ch);
            }
        }
        for(int i=0; i<26; i++){
            char ch = (char)(i + 'a');
            for(int j=0; j<lowerCase[i]; j++){
                sb.append(ch);
            }
        }
        return sb.toString();
