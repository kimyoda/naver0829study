package bit701.day0906;

public class Ex13_ArraySort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []data = {5, 3, 2, 4, 1};
		//selection sort
		//오름치순 정렬 : 기준이 비교되는 값보다 클 경우 바꾼다
		for(int i=0; i<data.length-1; i++) {
			for(int j=i+1; j<data.length; j++) {
				if(data[i]>data[j]){ //오름차순 정렬 부등호 반대시 내림차순
				//if(data[i]<data[j]) {	
					int temp = data[i];
					data[i] = data[j];
					data[j] = temp;
				}
			}
		}
		for(int n:data) {
			System.out.println(n);
		}

	}
}