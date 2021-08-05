# stack
# (, [ 각각 다른 스택에
# if ) and top == 2: pop
# if [ and top == 2: pop

sentence = input()
bracket = []
result = []
while sentence != ".":
    ans = 'yes'
    for w in sentence:
        if w == '(' or w == '[':
            bracket.append(w)
        elif w == ')':
            if len(bracket) == 0 or bracket[-1] != '(':
                ans = 'no'
                break
            else:
                bracket.pop()
        elif w == ']':
            if len(bracket) == 0 or bracket[-1] != '[':
                ans = 'no'
                break
            else:
                bracket.pop()
    # 괄호가 하나인 경우에는 남아있을 수 있으므로 처리해줘야함
    if bracket:
        ans = 'no'

    result.append(ans)
    bracket = []
    sentence = input()

for i in result:
    print(i)