data = input().split(' ');
a = int(data[0]);
b = int(data[1]);
c = int(data[2]);

cnt = 0;
while (b-a)>1 or (c-b)>1:
    if b - a < c - b:
        a = b;
        b += 1;
        cnt += 1;
    else:
        c = b;
        b -= 1;
        cnt += 1;
print(cnt);
