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

import java.io.IOException;

import org.influxdata.platform.error.InfluxException;

import okhttp3.mockwebserver.MockResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

/**
 * @author Jakub Bednar (bednar@github) (03/10/2018 15:08)
 */
@RunWith(JUnitPlatform.class)
class FluxClientVersionTest extends AbstractFluxClientTest {

    @Test
    void version() {

        MockResponse response = new MockResponse()
                .setResponseCode(204)
                .setHeader("X-Influxdb-Version", "1.7.0");
        fluxServer.enqueue(response);

        Assertions.assertThat(fluxClient.version()).isEqualTo("1.7.0");
    }

    @Test
    void versionUnknown() {

        MockResponse response = new MockResponse()
                .setResponseCode(204);
        fluxServer.enqueue(response);

        Assertions.assertThat(fluxClient.version()).isEqualTo("unknown");
    }

    @Test
    void error() throws IOException {
        fluxServer.shutdown();

        Assertions.assertThatThrownBy(() -> fluxClient.version()).isInstanceOf(InfluxException.class);
    }
}