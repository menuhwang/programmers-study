#include <iostream>

using namespace std;

int main()
{
    int arr[201] = {0};
    int n;

    cin >> n;

    int a;
    for (int i = 0; i < n; i++)
    {
        cin >> a;

        arr[a+100]++;
    }

    int i;

    cin >> i;

    cout << arr[i+100];

    return 0;
}