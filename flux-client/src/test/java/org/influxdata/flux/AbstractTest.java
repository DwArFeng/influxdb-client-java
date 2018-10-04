/*
 * The MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.influxdata.flux;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nonnull;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

/**
 * @author Jakub Bednar (bednar@github) (03/10/2018 14:54)
 */
public abstract class AbstractTest {

    protected CountDownLatch countDownLatch;

    @BeforeEach
    protected void prepare() {
        countDownLatch = new CountDownLatch(1);
    }

    protected void waitToCallback() {
        waitToCallback(10);
    }

    protected void waitToCallback(final int seconds) {
        waitToCallback(countDownLatch, seconds);
    }

    protected void waitToCallback(@Nonnull final CountDownLatch countDownLatch, final int seconds) {
        try {
            Assertions.assertThat(countDownLatch.await(seconds, TimeUnit.SECONDS))
                    .overridingErrorMessage("The countDown wasn't counted to zero. Before elapsed: %s seconds.", seconds)
                    .isTrue();
        } catch (InterruptedException e) {
            Assertions.fail("Unexpected exception", e);
        }
    }
}