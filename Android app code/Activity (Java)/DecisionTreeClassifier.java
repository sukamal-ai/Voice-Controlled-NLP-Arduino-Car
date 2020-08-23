package com.example.car_controller;

class DecisionTreeClassifier {

    private static int findMax(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            index = nums[i] > nums[index] ? i : index;
        }
        return index;
    }

    public static double[] getFeautres(String voice){

        //['back', 'backward', 'break', 'come', 'fast', 'forward', 'go',
        // 'left', 'leftside', 'move', 'quick', 'right', 'rightside',
        // 'slow', 'stop', 'straight', 'take', 'turn']
        double[] features = new double[20];
        String[] words = voice.split(" ");

        for(String word:words){
            switch (word){
                case "back": features[0] = 1;
                    break;
                case "backward": features[1] = 1;
                    break;
                case "break": features[2] = 1;
                    break;
                case "come": features[3] = 1;
                    break;
                case "fast": features[4] = 1;
                    break;
                case "forward": features[5] = 1;
                    break;
                case "go": features[6] = 1;
                    break;
                case "left": features[7] = 1;
                    break;
                case "leftside": features[8] = 1;
                    break;
                case "move": features[9] = 1;
                    break;
                case "quick": features[10] = 1;
                    break;
                case "reverse": features[11] = 1;
                    break;
                case "right": features[12] = 1;
                    break;
                case "rightside": features[13] = 1;
                    break;
                case "slow": features[14] = 1;
                    break;
                case "slowly": features[15] = 1;
                    break;
                case "stop": features[16] = 1;
                    break;
                case "straight": features[17] = 1;
                    break;
                case "take": features[18] = 1;
                    break;
                case "turn": features[19] = 1;
                    break;
            }
        }

        return features;

    }

    public static int predict(double[] features) {
        int[] classes = new int[7];

        if (features[14] <= 0.5) {
            if (features[15] <= 0.5) {
                if (features[0] <= 0.5) {
                    if (features[1] <= 0.5) {
                        if (features[7] <= 0.5) {
                            if (features[12] <= 0.5) {
                                if (features[11] <= 0.5) {
                                    if (features[8] <= 0.5) {
                                        if (features[13] <= 0.5) {
                                            if (features[2] <= 0.5) {
                                                if (features[16] <= 0.5) {
                                                    classes[0] = 18;
                                                    classes[1] = 0;
                                                    classes[2] = 0;
                                                    classes[3] = 0;
                                                    classes[4] = 0;
                                                    classes[5] = 0;
                                                    classes[6] = 0;
                                                } else {
                                                    classes[0] = 0;
                                                    classes[1] = 0;
                                                    classes[2] = 0;
                                                    classes[3] = 0;
                                                    classes[4] = 0;
                                                    classes[5] = 0;
                                                    classes[6] = 1;
                                                }
                                            } else {
                                                classes[0] = 0;
                                                classes[1] = 0;
                                                classes[2] = 0;
                                                classes[3] = 0;
                                                classes[4] = 0;
                                                classes[5] = 0;
                                                classes[6] = 1;
                                            }
                                        } else {
                                            classes[0] = 0;
                                            classes[1] = 0;
                                            classes[2] = 0;
                                            classes[3] = 0;
                                            classes[4] = 0;
                                            classes[5] = 1;
                                            classes[6] = 0;
                                        }
                                    } else {
                                        classes[0] = 0;
                                        classes[1] = 0;
                                        classes[2] = 0;
                                        classes[3] = 0;
                                        classes[4] = 1;
                                        classes[5] = 0;
                                        classes[6] = 0;
                                    }
                                } else {
                                    classes[0] = 0;
                                    classes[1] = 0;
                                    classes[2] = 2;
                                    classes[3] = 0;
                                    classes[4] = 0;
                                    classes[5] = 0;
                                    classes[6] = 0;
                                }
                            } else {
                                classes[0] = 0;
                                classes[1] = 0;
                                classes[2] = 0;
                                classes[3] = 0;
                                classes[4] = 0;
                                classes[5] = 3;
                                classes[6] = 0;
                            }
                        } else {
                            classes[0] = 0;
                            classes[1] = 0;
                            classes[2] = 0;
                            classes[3] = 0;
                            classes[4] = 3;
                            classes[5] = 0;
                            classes[6] = 0;
                        }
                    } else {
                        classes[0] = 0;
                        classes[1] = 0;
                        classes[2] = 5;
                        classes[3] = 0;
                        classes[4] = 0;
                        classes[5] = 0;
                        classes[6] = 0;
                    }
                } else {
                    classes[0] = 0;
                    classes[1] = 0;
                    classes[2] = 9;
                    classes[3] = 0;
                    classes[4] = 0;
                    classes[5] = 0;
                    classes[6] = 0;
                }
            } else {
                if (features[9] <= 0.5) {
                    if (features[6] <= 0.5) {
                        classes[0] = 0;
                        classes[1] = 0;
                        classes[2] = 0;
                        classes[3] = 3;
                        classes[4] = 0;
                        classes[5] = 0;
                        classes[6] = 0;
                    } else {
                        if (features[0] <= 0.5) {
                            if (features[1] <= 0.5) {
                                classes[0] = 0;
                                classes[1] = 3;
                                classes[2] = 0;
                                classes[3] = 0;
                                classes[4] = 0;
                                classes[5] = 0;
                                classes[6] = 0;
                            } else {
                                classes[0] = 0;
                                classes[1] = 0;
                                classes[2] = 0;
                                classes[3] = 1;
                                classes[4] = 0;
                                classes[5] = 0;
                                classes[6] = 0;
                            }
                        } else {
                            classes[0] = 0;
                            classes[1] = 0;
                            classes[2] = 0;
                            classes[3] = 1;
                            classes[4] = 0;
                            classes[5] = 0;
                            classes[6] = 0;
                        }
                    }
                } else {
                    classes[0] = 0;
                    classes[1] = 3;
                    classes[2] = 0;
                    classes[3] = 0;
                    classes[4] = 0;
                    classes[5] = 0;
                    classes[6] = 0;
                }
            }
        } else {
            if (features[0] <= 0.5) {
                if (features[1] <= 0.5) {
                    if (features[18] <= 0.5) {
                        classes[0] = 0;
                        classes[1] = 6;
                        classes[2] = 0;
                        classes[3] = 0;
                        classes[4] = 0;
                        classes[5] = 0;
                        classes[6] = 0;
                    } else {
                        classes[0] = 0;
                        classes[1] = 0;
                        classes[2] = 0;
                        classes[3] = 1;
                        classes[4] = 0;
                        classes[5] = 0;
                        classes[6] = 0;
                    }
                } else {
                    classes[0] = 0;
                    classes[1] = 0;
                    classes[2] = 0;
                    classes[3] = 3;
                    classes[4] = 0;
                    classes[5] = 0;
                    classes[6] = 0;
                }
            } else {
                classes[0] = 0;
                classes[1] = 0;
                classes[2] = 0;
                classes[3] = 3;
                classes[4] = 0;
                classes[5] = 0;
                classes[6] = 0;
            }
        }

        return findMax(classes);
    }

}