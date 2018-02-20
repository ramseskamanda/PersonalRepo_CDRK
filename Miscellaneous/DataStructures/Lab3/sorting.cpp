#include <iostream>
#include <vector>
#include <stdlib.h>
#include <stdio.h>
using namespace std;
typedef vector<vector<int>> vectorsarray;

vectorsarray cutArray(vector<int> arr, int mid){
	vector<int> first;
	vector<int> second;
	for(int i = 0; i < arr.size(); i++){
		if(i < mid) first.emplace_back(arr[i]);
		else second.emplace_back(arr[i]);
	}
	vectorsarray cut = {first, second};
	return cut;
}

vector<int> bubbleSort(vector<int> arr){
	int n = arr.size();
	int temp = 0;
	for(int i=0; i < n; i++){  
			for(int j=1; j < (n-i); j++){  
				if(arr[j-1] > arr[j]){ 
					temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	return arr;
}

vector<int> mergeSort(vector<int> arr){
	vector<int> result;
	if(arr.size() < 2)
		return arr;
	int mid = int(arr.size() / 2);
	vectorsarray cut = cutArray(arr, mid);
	vector<int> y = mergeSort(cut[0]);
	vector<int> z = mergeSort(cut[1]);
	int i = 0;
	int j = 0;
	while(i < y.size() && j < z.size()){
		if(y[i] > z[j]){
			result.emplace_back(z[j]);
			++j;
		}
		else{
			result.emplace_back(y[i]);
			++i;
		}
	}
	vector<int> addtoresult = cutArray(y, i)[1];
	vector<int> alsoaddtoresult = cutArray(z, j)[1];
	for(auto& el: addtoresult)
		result.emplace_back(el);
	for(auto& el: alsoaddtoresult)
		result.emplace_back(el);
	return result;
}

vector<int> mergeSortBubble(vector<int> arr){
	vector<int> result;
	if(arr.size() < 20)
		result = bubbleSort(arr);
	else{
		int mid = int(arr.size() / 2);
		vectorsarray cut = cutArray(arr, mid);
		vector<int> y = mergeSort(cut[0]);
		vector<int> z = mergeSort(cut[1]);
		int i = 0;
		int j = 0;
		while(i < y.size() && j < z.size()){
			if(y[i] > z[j]){
				result.emplace_back(z[j]);
				++j;
			}
			else{
				result.emplace_back(y[i]);
				++i;
			}
		}
		vector<int> addtoresult = cutArray(y, i)[1];
		vector<int> alsoaddtoresult = cutArray(z, j)[1];
		for(auto& el: addtoresult)
			result.emplace_back(el);
		for(auto& el: alsoaddtoresult)
			result.emplace_back(el);
	}
	return result;
}

int main(int argc, char const *argv[])
{
	vector<int> test;
	for(int i = 0; i < 10; i ++)
		test.emplace_back(rand() % 100);
	vector<int> result = mergeSortBubble(test);
	for(auto& el: result)
		cout << el << endl;
	return 0;
}