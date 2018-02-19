#include <iostream>
#include <vector>
#include <string>
using namespace std;

vector<int> longestStreak(vector<int> v){
	int biggest (0);
	int start (0);
	int end (0);
	for(int i = 1; i < v.size(); ++i){
		if(v[i - 1] > v[i]){
			if(biggest < (i -1) - start){
				end = i - 1;
				biggest = end - start;
			}
			if(v.size() - i < biggest) break;
			else start = i;
		}
	}
	start = end - biggest;
	vector<int> victor;
	for(int i = 0; i <= biggest; ++i)
		victor.emplace_back(v[start + i]);
	return victor;
}

int main(){
	vector<int> v1 {1, 3, 4, 5, 6, -1, 2, 1, 2, 1, 2};
	vector<int> s1 = longestStreak(v1);
	for(auto& e: s1)
		cout << to_string(e);
	return 0;
}