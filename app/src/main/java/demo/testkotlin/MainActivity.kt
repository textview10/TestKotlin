package demo.testkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    val TAG: String = "MainActivity";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var arrs = intArrayOf(12, 2, 44, 6, 98, 7, 3, 9)
//        bubbleSort(arrs)
        selectSort(arrs)
//        quickSort(arrs, 0, arrs.size - 1)
        logArray(arrs)
    }

    private fun quickSort(arrs: IntArray, lowStart: Int, highEnd: Int) {
        var low: Int = lowStart
        var high: Int = highEnd
        var povit: Int = arrs[low]

        while (low < high) {
            while (low < high && arrs[high] >= povit) {
                high--
            }
            if (low < high) {
                var temp: Int = arrs[high]
                arrs[high] = arrs[low]
                arrs[low] = temp
                low++
            }
            while (low < high && arrs[low] <= povit) {
                low++
            }
            if (low < high) {
                var temp: Int = arrs[high]
                arrs[high] = arrs[low]
                arrs[low] = temp
                high--
            }
        }
        if (low > lowStart) quickSort(arrs, lowStart, low - 1)
        if (high < highEnd) quickSort(arrs, low + 1, highEnd)
    }

    private fun selectSort(arrs: IntArray) {
        var outIndex: Int = 0
        var inIndex: Int = 0
        var minIndex: Int = 0
        while (outIndex < arrs.size - 1) {
            inIndex = outIndex + 1
            minIndex = outIndex
            while (inIndex < arrs.size) {
                if (arrs[minIndex] > arrs[inIndex]) {
                    minIndex = inIndex
                }
                inIndex++
            }
            if (minIndex != outIndex) {
                var temp: Int = arrs[outIndex]
                arrs[outIndex] = arrs[minIndex]
                arrs[minIndex] = temp
            }
            outIndex++
        }
    }

    private fun logArray(arrs: IntArray) {
        var sb: StringBuilder = StringBuilder();
        for ((index, value) in arrs.withIndex()) {
            if (index == 0) {
                sb.append("[ ").append(value).append(", ")
            } else if (index == arrs.size - 1) {
                sb.append(value).append("]")
            } else {
                sb.append(value).append(", ")
            }
        }
        Log.e(TAG, sb.toString())
    }

    //冒泡排序
    private fun bubbleSort(arrs: IntArray) {
        var outIndex: Int = 0
        var inIndex: Int = 0
        var temp: Int = 0
        while (outIndex < arrs.size) {
            inIndex = outIndex + 1;
            while (inIndex < arrs.size) {
                if (arrs[outIndex] > arrs[inIndex]) {
                    temp = arrs[outIndex]
                    arrs[outIndex] = arrs[inIndex]
                    arrs[inIndex] = temp
                }
                inIndex++
            }
            outIndex++
        }
    }


    //二分查找
    private fun binaryTest(arrs: IntArray, target: Int): Int {
        var start: Int = 0;
        var end: Int = arrs.size - 1;
        while (start <= end) {
            var middle: Int = (start + end) / 2;
            if (arrs.get(middle) == target) {
                return middle;
            } else if (arrs.get(middle) < target) {
                start = middle + 1
            } else if (arrs.get(middle) > target) {
                end = middle - 1;
            }
        }
        return -1;
    }
}
