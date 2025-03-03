
public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        trap(height);
    }

    public static int trap(int[] height) {
        int totalVolume = 0;
        int[] maxHeightFromleft = new int[height.length];
        int[] maxHeightFromRight = new int[height.length];

        for (int rightPointer = height.length - 2; rightPointer >= 0; rightPointer--) {
            maxHeightFromRight[rightPointer] = Math.max(maxHeightFromRight[rightPointer + 1], height[rightPointer + 1]);
        }
        for (int leftPointer = 1; leftPointer < height.length; leftPointer++) {
            maxHeightFromleft[leftPointer] = Math.max(maxHeightFromleft[leftPointer - 1], height[leftPointer - 1]);
        }

        for (int mainPointer = 1; mainPointer < height.length - 1; mainPointer++) {
            int leftMaximum = maxHeightFromleft[mainPointer];
            int rightMaximum = maxHeightFromRight[mainPointer];

            int minHeightOnSides = Math.min(leftMaximum, rightMaximum);
            int currentIndexHeight = height[mainPointer];

            if (currentIndexHeight >= minHeightOnSides) {
                continue;
            }

            int volumePossibleInCurrentIndex = minHeightOnSides - currentIndexHeight;
            totalVolume = totalVolume + volumePossibleInCurrentIndex;

        }

        return totalVolume;
    }
}
