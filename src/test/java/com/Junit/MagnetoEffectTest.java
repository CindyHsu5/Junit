package com.Junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MagnetoEffectTest {
	
	private MagnetoEffect magnetoEffect = new MagnetoEffect();
	private Point beforePoint;
	private Point afterPoint;
	
	@Test
	void no_anchor() {
		
		given_mouse_was_at(49, 50);
		when_check();

		then_mouse_new_position_is(49, 50);
		
	}
	
	private void given_mouse_was_at(int x, int y) {
		beforePoint = new Point(x, y);
	}
	
	private void when_check() {
		afterPoint = magnetoEffect.check(beforePoint);
	}
	
	private void then_mouse_new_position_is(int x, int y) {
		Assertions.assertEquals(new Point(x, y), afterPoint);
	}
	
	@Test
	void no_near_anchor() {

		given_anchor_is(50, 50);
		given_mouse_was_at(49, 50);
		when_check();
		then_mouse_new_position_is(50, 50);
		
	}
	
	private void given_anchor_is(int x, int y) {
		magnetoEffect.addAnchor(new Point(x, y));
	}
	
	@Test
	void one_far_anchor() {
		
		given_anchor_is(0, 0);
		given_mouse_was_at(49, 50);
		when_check();
		then_mouse_new_position_is(49, 50);
		
	}
	
	
	@Test
	void two_anchors_amd_only_is_near() {
		
		given_anchor_is(50, 50);
		given_anchor_is(0, 0);
		
		given_mouse_was_at(49, 50);
		when_check();
		then_mouse_new_position_is(50, 50);
		
	}
	
	@Test
	void two_anchors_and_both_are_near() {
		given_anchor_is(50, 50);
		given_anchor_is(50, 49);
		
		given_mouse_was_at(49, 50);
		when_check();
		then_mouse_new_position_is(50, 50);
	}
}
