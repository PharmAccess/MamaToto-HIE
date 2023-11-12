/*
 * Copyright 2020-2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.fhir.analytics;

import org.apache.beam.sdk.options.Default;
import org.apache.beam.sdk.options.Description;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.Validation.Required;

/** Options supported by {@link ParquetMerger}. */
public interface ParquetMergerOptions extends PipelineOptions {

  @Description(
      "The path to the first set of Parquet files to be merged; the data-warehouse file  structure"
          + " generated by FhirEtl is expected, i.e., one subdirectory per resource type. ")
  @Required
  @Default.String("")
  String getDwh1();

  void setDwh1(String value);

  @Description(
      "The path to the second set of Parquet files to be merged; the data-warehouse file  structure"
          + " generated by FhirEtl is expected, i.e., one subdirectory per resource type. ")
  @Required
  @Default.String("")
  String getDwh2();

  void setDwh2(String value);

  @Description("The path to the final merged Parquet files with the same file structure. ")
  @Required
  @Default.String("")
  String getMergedDwh();

  void setMergedDwh(String value);

  @Description(
      "The number of output file shards for each resource type. Ideally this should"
          + "automatically be determined by the runner. But leaving this to FlinkRunner, it"
          + "fails to write all records; TBD why! ")
  @Required
  @Default.Integer(20)
  int getNumShards();

  void setNumShards(int value);
}
