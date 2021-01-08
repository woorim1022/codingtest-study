# 문자열 슬라이싱 대해 공부

# while True:
str = input();
ucpc = 'UCPC';
tf = [False,False,False,False];
for i in range(4):
    for j in range(len(str)):
        if str[j] == ucpc[i]:
            str = str[j+1:];
            # print(str)
            tf[i] = True;
            break;
# print(tf)
if tf[0]==True and tf[1]==True and tf[2]==True and tf[3]==True:
    print('I love UCPC');
else:
    print('I hate UCPC');


