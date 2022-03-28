package com.namanh.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/course-schedule
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array
 * prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take
 * course ai. For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 *
 * S1: Create prerequisites map
 * S2: Use recursion to check all prerequisites course, mark true if we can finish it
 *
 * TODO: Topological Sorting (https://vnoi.info/wiki/algo/graph-theory/topological-sort.md)
 * - Danh sach cac dinh khong co cung vao
 * - Danh sach canh ra
 * - So luong canh vao
 */
public class CourseSchedule {
    Map<Integer, List<Integer>> preMap = new HashMap<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int[] pre : prerequisites) {
            List<Integer> curPre = preMap.getOrDefault(pre[0], new ArrayList<>());
            curPre.add(pre[1]);
            preMap.put(pre[0], curPre);
        }
        int[] courses = new int[numCourses];
        boolean result = true;
        for (int i = 0; i < numCourses; i++) {
            result &= markCourse(courses, i);
        }
        return result;
    }

    private boolean markCourse(int[] courses, int index) {
        if (courses[index] == 2) return true;
        if (courses[index] == 1) return false;
        if (preMap.containsKey(index)) {
            courses[index] = 1;
            List<Integer> pre = preMap.get(index);
            boolean canLearn = true;
            for (int p : pre) {
                canLearn &= markCourse(courses, p);
            }
            if (canLearn) courses[index] = 2;
        } else {
            courses[index] = 2;
        }
        return courses[index] == 2;
    }
}
