def longestStreak(array):
    biggest = 0
    start = 0
    end = 0
    for i in range(1, len(array)):
            if (array[i - 1] > array[i]):
                if (biggest < (i - 1) - start):
                    end = i
                    biggest = end - start
                if (len(array) - i < biggest): break
                else: start = i
    start = end - biggest
    return array[start:end]

if __name__ == '__main__':
    t1 = [1, 3, 4, 5, 6, -1, 2, 1, 2, 1, 2]
    t2 = [1, 2, 3, 4, 5, 6, -1, 2, 1, 2, 1, 2]
    t3 = [-1, 2, 5,1, 2, 1, 2]
    solution1 = longestStreak(t1)
    solution2 = longestStreak(t2)
    solution3 = longestStreak(t3)
    print(solution1)
    print(solution2)
    print(solution3)
