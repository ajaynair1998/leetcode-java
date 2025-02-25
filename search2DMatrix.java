public class search2DMatrix {
  public boolean searchMatrix(int[][] matrix, int target) {
    int leftPointer = 0;
    int rightPointer = matrix.length - 1;

    while (leftPointer <= rightPointer) {
      int currentBlockIndex = (int) Math.floor((leftPointer + rightPointer) / 2);
      int leftMostValueInCurrentBlock = matrix[currentBlockIndex][0];
      int rightMostValueInCurrentBlock = matrix[currentBlockIndex][matrix[currentBlockIndex].length - 1];

      if (leftMostValueInCurrentBlock <= target && rightMostValueInCurrentBlock >= target) {
        return search1DMatrix(matrix[currentBlockIndex], target);
      } else if (target < leftMostValueInCurrentBlock) {
        rightPointer--;
      } else if (target > rightMostValueInCurrentBlock) {
        leftPointer++;
      }
    }

    return false;
  }

  public boolean search1DMatrix(int[] array, int target) {
    int leftPointer = 0;
    int rightPointer = array.length - 1;

    while (leftPointer <= rightPointer) {
      int midPointer = (int) Math.floor((leftPointer + rightPointer) / 2);
      int valueAtMid = array[midPointer];

      if (target == valueAtMid) {
        return true;
      } else if (valueAtMid < target) {
        leftPointer++;
      } else if (valueAtMid > target) {
        rightPointer--;
      }
    }
    return false;
  }
}
