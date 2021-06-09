from itertools import permutations
from math import sqrt
from math import ceil


def solution(numbers):
    answer = 0
    perm = [set(permutations(numbers, i)) for i in range(1, len(numbers) + 1)]
    visited = []

    for i in perm:
        for j in i:
            numstring = ''
            prime = True
            for k in range(len(j)):
                numstring += j[k]
            numint = int(numstring)
            #print(numint)
            if not numint in visited:
                #print(numint)
                visited.append(numint)
                for p in range(2, int(sqrt(numint)) + 1):
                    if numint % p == 0:
                        prime = False
                if prime == True and numint not in [0, 1]:
                    answer += 1

    print(answer)
    return answer


solution("011")
