/*
 * INSTRUCTION:
 *     This is a C++ starting code for hw 0_1.
 */

// Finish the head comment with Abstract, Name, and Date.
/*
 * Title: main_hw0_1.cc
 * Abstract: Write the main purpose of the program.
 * Name: Write your name
 * Date: MM/DD/YYYY
 */

#include <iostream>
using namespace std;

int main()
{
    // Your code should be here.
    // The following is a just sample statement.
    int a[5];
    int temp;
    for (int i = 0; i < 5; i++) {
        cin >> a[i];
    }
    int min = a[0], max = a[0];
    for (int i = 1; i < 5; i++) {
        if (min > a[i]) {
            min = a[i];
        }
        if (max < a[i]) {
            max = a[i];
        }
    }
    for (int i = 1; i <= 5; i++) {
        for (int j = 0; j < 4; j++) {
            if (a[j] > a[j + 1]) {
                temp = a[j];
                a[j] = a[j + 1];
                a[j + 1] = temp;
            }
        }
    }

    cout << "MIN:" << min << endl;
    cout << "MAX:" << max << endl;
    cout << "MEDIAN:" << a[2] << endl;

    return 0;
}

