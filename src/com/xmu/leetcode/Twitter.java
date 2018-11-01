package com.xmu.leetcode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

class Twitter {

	final int MAX_TWEET = 10;
	int timeStamp;
	Map<Integer, Set<Integer>> followings;
	Map<Integer, Queue<Tweet>> tweets;
	Comparator<Tweet> com;

	/** Initialize your data structure here. */
	public Twitter() {
		timeStamp = 0;
		followings = new HashMap<>();
		tweets = new HashMap<>();
		com = new Comparator<Tweet>() {
			public int compare(Tweet o1, Tweet o2) {
				return o1.time - o2.time;
			}
		};
	}

	/** Compose a new tweet. */
	public void postTweet(int userId, int tweetId) {
		tweets.putIfAbsent(userId, new LinkedList<>());
		tweets.get(userId).offer(new Tweet(tweetId, timeStamp++));
		if (tweets.get(userId).size() > MAX_TWEET) {
			tweets.get(userId).poll();
		}
	}

	/**
	 * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in
	 * the news feed must be posted by users who the user followed or by the user
	 * herself. Tweets must be ordered from most recent to least recent.
	 */
	public List<Integer> getNewsFeed(int userId) {
		List<Integer> result = new ArrayList<>();
		Queue<Tweet> pq = new PriorityQueue<>(com);
		if (tweets.containsKey(userId)) {
			for (Tweet t : tweets.get(userId)) {
				pq.offer(t);
			}
		}
		if (followings.containsKey(userId)) {
			for (int f : followings.get(userId)) {
				if (tweets.containsKey(f)) {
					for (Tweet t : tweets.get(f)) {
						pq.offer(t);
					}
				}
			}
		}
		while (!pq.isEmpty()) {
			if (pq.size() <= MAX_TWEET) {
				result.add(0, pq.poll().id);
			} else {
				pq.poll();
			}
		}
		return result;
	}

	/**
	 * Follower follows a followee. If the operation is invalid, it should be a
	 * no-op.
	 */
	public void follow(int followerId, int followeeId) {
		if (followerId == followeeId) {
			return;
		}
		followings.putIfAbsent(followerId, new HashSet<>());
		followings.get(followerId).add(followeeId);
	}

	/**
	 * Follower unfollows a followee. If the operation is invalid, it should be a
	 * no-op.
	 */
	public void unfollow(int followerId, int followeeId) {
		if (followerId == followeeId || !followings.containsKey(followerId)
				|| !followings.get(followerId).contains(followeeId)) {
			return;
		}
		followings.get(followerId).remove(followeeId);
	}

	class Tweet {
		int id;
		int time;

		public Tweet(int id, int time) {
			this.id = id;
			this.time = time;
		}
	}
}