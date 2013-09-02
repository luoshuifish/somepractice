
def caesar_cipher(c, num):
    if c.islower():
        return chr(97 + ((ord(c) + num) - 97) % 26)
    else:
        return chr(65 + ((ord(c) + num) - 65) % 26)

file = open('D:/text.txt', 'r')

str = file.read()
length = len(str)

def caesar_cipher_tostr(num):
    str_temp = []
    for i in range(0, length):
        if str[i].isalpha():
            str_temp.append(caesar_cipher(str[i], num))
        else:
            str_temp.append(str[i])
    return "".join(str_temp)

file.close()

#print str_temp


for i in range (1, 25):
    file_temp = open("%s%d%s"%('D:/text',i,'.txt'), 'w')
    file_temp.write(caesar_cipher_tostr(i))


    

