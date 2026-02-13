public class Cipher
{
    private String referenceKey;
    private String cipherKey;

    public Cipher(String referenceKey, String cipherKey)
    {
        validate(referenceKey, cipherKey);

        this.referenceKey = referenceKey;
        this.cipherKey = cipherKey;
    }

    public String decipher(String encryptedText)
    {
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < encryptedText.length(); i++)
        {
            char encryptedChar = encryptedText.charAt(i);

            int index = cipherKey.indexOf(encryptedChar);

            if(index != -1)
            {
                char plainChar = referenceKey.charAt(index);
                result.append(plainChar);
            }
            else {
                result.append(encryptedChar);
            }
        }
        return result.toString();
    }

    private void validate(String reference, String key)
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
        for(int i = 0; i < key.length(); i++)
        {
            char c = key.charAt(i);
            if(key.indexOf(c) != key.lastIndexOf(c))
            {
                throw new IllegalArgumentException("Duplicate character in key" + c);
            }
        }
    }
}
