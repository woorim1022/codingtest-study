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
                continue
            else:
                bracket.pop()
        elif w == ']':
            if len(bracket) == 0 or bracket[-1] != '[':
                ans = 'no'
                continue
            else:
                bracket.pop()
        else: continue
    result.append(ans)
    bracket = []
    sentence = input()

for i in result:
    print(i)