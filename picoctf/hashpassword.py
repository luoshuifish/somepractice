#����ʵ�ֵ���Banker��s Sequence�㷨
global string, len_str, right_most_flag , carry_bit

string = [1 , 0 , 0 , 0]

len_str = 4

#��¼���ұ�־λ
right_most_flag = 0

#��λλ��
carry_bit = -1


#���λ��1
def addHighestBit():
    global carry_bit
    for i in range(0, len_str):
        if string[i] == 0:
            string[i] = 1
            carry_bit = i
            return
        else:
            string[i] = 0

def shfitBit():
    global carry_bit, right_most_flag
    index_zero = carry_bit
    while (string[index_zero] == 1):
        if (index_zero < (len_str-1)):
            index_zero+= 1
        else:
            break

    count_one = 0
    for i in range(index_zero, len_str):
        if (string[i] == 1):
            count_one += 1
            string[i] = 0
    
    for i in range(count_one, 0 , -1):
        string[index_zero] = 1
        index_zero += 1

    right_most_flag = index_zero - 1



def init():
    global carry_bit
    carry_bit = -1
    

def output():
    global right_most_flag
    #������������ƵĻ�
    if right_most_flag < (len_str - 1):
        string[right_most_flag] = 0
        right_most_flag += 1
        string[right_most_flag] = 1
    else:
        addHighestBit()
        shfitBit()
        init()
    return string
        
        
    

