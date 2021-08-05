# import heapq
#
# # heapq 모듈은 리스트를 최소 힙처럼 다룰 수 있도록 하기 때문에, 빈 리스트를 생성한 후 heapq의
# # 함수를 호출할 때마다 리스트를 인자에 넘겨야 한다.
# heap = []
# heapq.heappush(heap,50)
# heapq.heappush(heap,10)
# heapq.heappush(heap,20)
# heapq.heappush(heap,30)
# print(heap)
#
# # 이미 생성해둔 리스트가 있다면 heqpify 함수를 통해 즉각적으로 힙 자료형으로 변환할 수 있다.
# heap2 = [50,10,20]
# heapq.heapify(heap2)
# print(heap2)