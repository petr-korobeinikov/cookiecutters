package solution_test

import (
	"github.com/stretchr/testify/assert"
	"testing"

	. "solution"
)

func TestF(t *testing.T) {
	tests := []struct {
		name     string
		expected bool
	}{
		{
			name:     `leetcode-1`,
			expected: true,
		},
	}

	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			assert.Equal(t, true, F())
		})
	}
}
