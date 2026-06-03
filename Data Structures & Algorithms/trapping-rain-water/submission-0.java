class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length-1;
        int lmax = 0, rmax = 0;
        int water = 0;
        while(left < right) {
            lmax = Math.max(lmax, height[left]);
            rmax = Math.max(rmax, height[right]);
            if(lmax < rmax) {
                water += lmax - height[left];
                left ++;
            } else {
                water += rmax - height[right];
                right --;
            }
        }
        return water;
    }

    public int trapDP(int[] height) {
        int[] lmax = new int[height.length];
        int[] rmax = new int[height.length];

        for(int i=1; i<lmax.length-1;i++) {
            lmax[i] = Math.max(lmax[i-1], height[i-1]);
        }
        for(int j=rmax.length-2; j>=0; j--) {
            rmax[j] = Math.max(rmax[j+1], height[j+1]);
        }

        // water is bound by two things, left and right higher pillers
        // so we calculate height left and right pillars on either side of each above
        // if current pillar is higher than both, no water stored, 
        // otherwise min of left and right height minus current height
        int water = 0;
        for(int i=0;i<height.length;i++) {
            int currWater = Math.min(lmax[i], rmax[i]) - height[i];
            // if side pillars are lower, above will give negative
            if(currWater > 0) water += currWater;
        }
        return water;
    }
}
