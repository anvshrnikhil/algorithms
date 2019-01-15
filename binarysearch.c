
#include <stdio.h>
int binarysearch(int,int,int);
int a[100];
void main()
{
	int n=0;
	int i=0;
	int result=-1;
	int key=0;
	printf("Enter the size of array:");
	scanf("%d",&n);
	printf("Enter the values to array:\n");
	for(i=0;i<n;i++)
	{
		scanf("%d",&a[i]);
	}
	printf("Enter the element to search:");
	scanf("%d",&key);
	result=binarysearch(0,n-1,key);
	if(result==-1){
		printf("Element is not found\n\n");
	}
	else{
		printf("Element %d is found\n\n",a[result]);
	}
}
int binarysearch(int low,int high,int key)
{
	int mid=(low+high)/2;
	if(low<=high){
		if(a[mid]==key)
		{
			//printf("Element is found\n\n");
			return mid;
		}
		else if(a[mid]<key)
		{
			//printf("Element is not between %d and %d\n\n",low,mid);
			return binarysearch(mid+1,high,key);
		}
		else
		{
			//printf("Element is not between %d and %d\n\n",mid,high);
			return binarysearch(low,mid-1,key);
		}
	}
	else return -1;
}
