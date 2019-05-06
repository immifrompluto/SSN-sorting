<h1>Design and Implementation</h1>
A NumberGenerator class was created to generate SSN numbers that satisfies
the requirement by generating area number, group number, and serial number. write()
method in main class saves the number into a txt file in String format. The read()
method parses the txt file numbers into int, and creates a new ArrayList of numbers and
returns the ArrayList. When one of the sorting method calls the method read(), the
returned ArrayList is used in a new ArrayList and the arrayList is passed into the class
when called. QuickSort is straightword, takes the ArrayList of numbers, creates a
partition, recursively calls itself unless completely sorted. RadixSort sorts all the
numbers digit by digit. Out of the 9 digits, every digit is individually sorted by counting
sort starting from LSD, and stops once the whole list is sorted.BucketSort sorts all the
numbers by creating buckets. In this we create buckets ranging from 0 to 9, total of 10
buckets. It is all created in a nested ArrayList. One ArrayList contains the buckets, and
the other contains of items in the bucket. Elements are added to the bucket in the
ArrayList, and that ArrayList is sorted using insertionSort.
<h1>Classes / Subroutines / Function Calls</h1>
<ul>
<h4>NumberGenerator</h3>
<li> NumberGenerator generates random number for SSN based on area </li>
number, group number, serial number
<li> getAreaNumber generates area number for the SSN randomly </li>
<li> getGroupNumber generates group number for the SSN randomly </li>
<li> getSerialNumber generates serial number for the SSN randomly </li>
<h4>QuickSort</h3>
<li>QuickSort class that sorts the list of SSNs using QuickSort sorting
algorithm </li>
<li>quickSort creates partition and recursively calls itself unless the list
is completely sorted</li>
<li>partition creates a pivot, compares the pivot with the numbers in
array and swaps them if the number is lower than the pivot and </li>
returns a value to the quickSort method.
<h3>RadixSort</h3>
<li>RadixSort class that sorts the list of SSNs using the RadixSort sorting
algorithm</li>
<li>radixSort sorts the arrayList by LSD</li>
<li>countSort method that sorts the element based on each digit given
by radixSort method in linear time</li>
<h3>BucketSort</h3>
<li>BucketSort class sorts the list of SSNs using the BucketSort algorithm</li>
<li>In bucketSort, a nested arrayList is created. The nested ArrayList is
the bucket where each of the element will be stored based on the
bucket number which is assigned to the element based on total
buckets and increase </li>
<li>insertionSort method that sorts element given by the bucketSort
method.</li>
<h3>Main</h3>
<li>Finally, main class is the class that executes all the created classes </li>
<li>main calls all the sorting</li>
<li>quickSort creates an instance of the class QuickSort and runs the
sorting and saves it to a specific location</li>
<li>radixSort creates an instance of the class RadixSort and runs the
sorting and saves it to a specific location</li>
<li>bucketSort creates an instance of the class BucketSort and runs
the sorting and saves it to a specific location</li>
<li>Location creates a txt file for the sorted numbers, and assigns
people location based on their SSN number in the sorted file, when
it is being called</li>
<li>write writes the generated SSN numbers to text file by creating an
instance of NumberGenerator class</li>
<li>read reads the generated SSN txt files and parses them to integer
for sorting purpose</li>
