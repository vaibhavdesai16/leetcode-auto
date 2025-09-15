func canReach(arr []int, start int) bool {
    visited := make([]bool, len(arr))
	return dp(arr, start, visited)
}

func dp(arr []int, idx int, visited []bool) bool {
	if idx < 0 || idx >= len(arr) {
		return false
	}

	if visited[idx] {
		return false
	}

	if arr[idx] == 0 {
		return true
	}

	visited[idx] = true

	left := dp(arr, idx-arr[idx], visited)
	right := dp(arr, idx+arr[idx], visited)

	return left || right
}