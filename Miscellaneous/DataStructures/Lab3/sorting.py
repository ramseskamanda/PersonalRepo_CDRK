import time
import numpy as np
from tqdm import tqdm

def mergeSort(arr):
	result = []
	if len(arr) < 2:
		return arr
	mid = int(len(arr) / 2)
	y = mergeSort(arr[:mid])
	z = mergeSort(arr[mid:])
	i = 0
	j = 0
	while i < len(y) and j < len(z):
		if y[i] > z[j]:
			result.append(z[j])
			j += 1
		else:
			result.append(y[i])
			i += 1
	result += y[i:]
	result += z[j:]
	return result

def mergeSortBubble(arr):
	result = []
	if len(arr) < 20:
		result = bubbleSort(arr)
	else:
		mid = int(len(arr) / 2)
		y = mergeSort(arr[:mid])
		z = mergeSort(arr[mid:])
		i = 0
		j = 0
		while i < len(y) and j < len(z):
			if y[i] > z[j]:
				result.append(z[j])
				j += 1
			else:
				result.append(y[i])
				i += 1
		result += y[i:]
		result += z[j:]
	return result

def bubbleSort(arr):
    for passnum in range(len(arr)-1,0,-1):
        for i in range(passnum):
            if arr[i]>arr[i+1]:
                temp = arr[i]
                arr[i] = arr[i+1]
                arr[i+1] = temp

def test(data_size, bubble=False):
	t = []
	tester = np.random.randint(0, 1000000, size=(data_size)).tolist()
	for _ in tqdm(range(10)):
		if bubble:
			tb = time.clock()
			mergeSortBubble(tester)
			tf = time.clock()
			t.append(tf - tb)
		else:
			tb = time.clock()
			mergeSort(tester)
			tf = time.clock()
			t.append(tf - tb)
	return np.mean(t)

def main():
	print('working')
	tests = [1000, 10000, 100000, 150000, 250000]
	results = [test(size) for size in tests]
	resultsbubble = [test(size, bubble=True) for size in tests]
	print("Actual:", results)
	print("Actual Bubble:", resultsbubble)
	print("Hypothetical:", np.log(tests))

if __name__ == '__main__':
	main()