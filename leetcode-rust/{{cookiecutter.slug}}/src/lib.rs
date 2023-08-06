#[derive(Debug)]
struct Solution {
}

impl Solution {
    #[allow(dead_code)]
    pub fn add(left: usize, right: usize) -> usize {
        left + right
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn it_works() {
        let result = Solution::add(2, 2);
        assert_eq!(result, 4);
    }
}
