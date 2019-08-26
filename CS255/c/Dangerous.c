int main() 
{
	int a, *p;
	float b, *q;

	b = 2.0;
	a = b;

	printf("a = %d \t b = %f\n", a, b);

	p = (int *)&b;
	a = *p;

	printf("a = %d, b = %f\n", a, b);
}