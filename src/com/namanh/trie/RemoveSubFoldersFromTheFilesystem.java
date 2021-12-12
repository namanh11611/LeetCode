package com.namanh.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/remove-sub-folders-from-the-filesystem
 * Given a list of folders folder, return the folders after removing all sub-folders in those folders.
 *
 * S1: Because character '/' has ASCII less than 'a', so after sort, we have order [...'/a/a', '/aaa'...]
 * S2: Compare folder with last element in result
 */
public class RemoveSubFoldersFromTheFilesystem {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> result = new ArrayList<>();
        for (String f : folder) {
            if (result.isEmpty() || !f.startsWith(result.get(result.size() - 1) + '/')) {
                result.add(f);
            }
        }

        return result;
    }
}
