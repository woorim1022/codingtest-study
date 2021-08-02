T = int(input())

for i in range(T):
    ans = 0
    tc = list(input())
    for j in range(len(tc)):
        if j == 0 and tc[j] == "1":
            ans += 1
        if j != 0 and tc[j] == "1" and tc[j-1] == "0":
            ans += 1
        if j != 0 and tc[j] == "0" and tc[j-1] == "1":
            ans +=1
    print("#" + str(i+1) + " " + str(ans))