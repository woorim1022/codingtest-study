cap = list(map(int, input().split()));
box = list(map(int, input().split()));
book = list(map(int, input().split()));

j = 0;
wasteCap = 0;
for i in range(0, cap[0]):
    # 박스 용량이 책 크기보다 크거나 같으면
    if box[i] >= book[j]:
        # 박스의 용량에서 책의 크기만큼을 뺀다.
        box[i] -= book[j];
        # 다음 책으로 넘어간다
        j += 1;
        # 만약 다음 책 번호가 책 개수보다 크면
        if j >= cap[1]:
            # 정리 끝
            break;
        # 박스는 현재 박스를 유지한다
        i -= 1;
for i in box:
    wasteCap += i;
print(wasteCap);