public class Cipher
{
    private String referenceKey;
    private String cipherKey;

    public Cipher(String referenceKey, String cipherKey)
    {
        validate(referenceKey, cipherKey);      //check first if reference and cipher keys are valid

        this.referenceKey = referenceKey;
        this.cipherKey = cipherKey;
    }

    public String decipher(String encryptedText)
    {
        StringBuilder result = new StringBuilder();     //create a mutable string, more efficient than normal String class

        for(int i = 0; i < encryptedText.length(); i++)     //loop through each char in the encrypted text
        {
            char encryptedChar = encryptedText.charAt(i);   //save each encrypted char

            int index = cipherKey.indexOf(encryptedChar);   //find index of encrytedChar in the cipher key

            if(index != -1)         //if found, match the index to the reference key
            {
                char plainChar = referenceKey.charAt(index);
                result.append(plainChar);       //add to result string
            }
            else {          //if not found, probably whitespace so add it
                result.append(encryptedChar);
            }
        }
        return result.toString();   //return result
    }

    private void validate(String reference, String key)     //make sure reference and cipher keys are valid
    {
        //check if null
        if (reference == null || key == null) {
            throw new IllegalArgumentException("Key lines cannot be null");
        }
        //check if lengths are same
        if(reference.length() != key.length())
        {
            throw new IllegalArgumentException("Key lines must have the same length");
        }
        //check if duplicate chars
        for(int i = 0; i < key.length(); i++)
        {
            char c = key.charAt(i);
            if(key.indexOf(c) != key.lastIndexOf(c))
            {
                throw new IllegalArgumentException("Duplicate character in key" + c);
            }
        }
    }

    public String getReferenceKey() {
        return referenceKey;
    }

    public String getCipherKey() {
        return cipherKey;
    }
}
