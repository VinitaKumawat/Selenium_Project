Feature: Image Alignment Verification

Scenario: Verify images are aligned correctly on the homepage
    Given User on the demoBlaze homepage
    When I verify the alignment of product images
    Then all product images should be properly aligned and consistent