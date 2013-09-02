def str_verity(num):
  result_num = None
  for i in range(1,256):
    if ((((i << 5) | (i >> 3)) ^ 111) & 255) == num:
      result = i
      break
  return chr(result)

for i in verify_arr:
  print str_verity(i),
      
    
