class Solution {
    public long mostPoints(int[][] questions) {

        long [] dp = new long [questions.length];
        dp[questions.length-1] = questions[questions.length-1][0];
        for(int i=questions.length-2; i>=0; i--) {
            int skip = i+1+questions[i][1];
            if(skip>questions.length-1){
                dp[i] = Math.max(questions[i][0], dp[i+1]);
            } else {
                dp[i] = Math.max(Math.max(questions[i][0], dp[i+1]), questions[i][0]+dp[skip]);
            }
        }

        return  dp[0]; 
    }
}